import java.io.*;

public class Test {
    public static void main ( String [] args ) throws IOException {
        for (String a:
             args) {
            System.out.println(args);
        }
        //"javac HelloWorld.java" "java HelloWorld"
        String result = execute( "javac F:\\education\\nulp\\architecture_of_software\\project\\src\\main\\java\\HelloWorld.java" );
        String result2 = execute( "java -cp F:\\education\\nulp\\architecture_of_software\\project\\src\\main\\java HelloWorld");
        System.out.println( result );
        System.out.println( result2 );
    }
    private static String execute( String command ) throws IOException  {




        Runtime rt = Runtime.getRuntime();

        Process proc = rt.exec(command);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));

// Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

// Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        return "";
    }
}