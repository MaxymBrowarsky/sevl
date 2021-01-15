package ua.nulp.sevl.coding.util;

import ua.nulp.sevl.coding.model.TestCase;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeExecutor {

    public void SaveToFile(String text){
        try {
            FileWriter myWriter = new FileWriter("Test.java");
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void compile() throws CompileException{
        try {
            InnerClass executionResult = execute("javac Test.java");

            if(!executionResult.errorOutput.isEmpty()){
                throw new CompileException();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TestResult executeCode(TestCase testCase) throws BadCodeException{
        try {
            InnerClass executionResult = execute("java Test");

            if(!executionResult.errorOutput.isEmpty()){
                BadCodeException exc =  new BadCodeException();
                exc.setErrMessage(executionResult.errorOutput);
                throw exc;
            } else {
                if(testCase.getResult().equals(executionResult.output)){
                    return new TestResult(true, executionResult.output);
                } else {
                    return new TestResult(false, executionResult.output);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new TestResult(false,"");
    }


    public static InnerClass execute( String command ) throws IOException {

        Runtime rt = Runtime.getRuntime();

        Process proc = rt.exec(command);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));

// Read the output from the command
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
            stringBuilder.append(s);
        }

// Read any errors from the attempted command
        StringBuilder errorStringBuilder = new StringBuilder();

        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
            errorStringBuilder.append(s);
        }

        InnerClass obj = new InnerClass(stringBuilder.toString(),errorStringBuilder.toString());

        return obj;
    }

    static class InnerClass{
        String output;
        String errorOutput;

        public InnerClass(String output, String errorOutput) {
            this.output = output;
            this.errorOutput = errorOutput;
        }
    }

    public class TestResult{
        boolean success;
        String result;

        public TestResult(boolean success, String result) {
            this.success = success;
            this.result = result;
        }

        public boolean isSuccess() {
            return success;
        }

        public TestResult setSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public String getResult() {
            return result;
        }

        public TestResult setResult(String result) {
            this.result = result;
            return this;
        }
    }
}
