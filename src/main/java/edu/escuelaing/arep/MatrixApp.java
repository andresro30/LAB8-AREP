package edu.escuelaing.arep;


import edu.escuelaing.arep.server.MatrixCalculator;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class MatrixApp
{
    public static void main( String[] args )
    {
        port(getPort());
        secure("keyStores/ecikeystore.p12", "123456",  null,null);
        get("/", (req,res) -> principalPage());
        get("/submit", (req,res) -> calculateMatrix(req,res));
    }

    public static String calculateMatrix(Request req, Response res){
        String size = req.queryParams("fsize");
        MatrixCalculator calculator = new MatrixCalculator();
        int[][] matrix = calculator.getResult(size);
        String reponse = "<DOCTYPE html"
                + "<html>"
                + "<title> Web Calculator</title>"
                + "<body>"
                + "<h1>Results</h1>"
                + "<h3>Matrix 's size: " + size+ "</h3>"
                + "<h3>Matrix : " + calculator.toStringMatrix(matrix) + "</h3>"
                + "</body>"
                + "</html>";;

        return reponse;
    }

    public static String principalPage(){
        String page;

        page = "<DOCTYPE html"
                + "<html>"
                + "<title> Matrix Calculator</title>"
                + "<body>"
                + "<h1>Matrix Calculator</h1>"
                + "<form action=\"/submit\">"
                + "<p>This calculator have some operations of matrix</p>"
                + "<p>Please follow the next recommendations  to get the most out of this tool:</p>"
                + "<ol>"
                + "<li>Write in field the size that you want to create the matrix</li>"
                + "<li>When you have been created the matrix you can multiply them clicking the 'Submit' button </li>"
                + "</ol>"
                + "<br></br>"
                + "<label for=\"fdata\">Matrix size:</label>"
                + "<input type=\"text\" id=\"fsize\" name=\"fsize\"><br><br>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return page;
    }



    /**
     * Método enccargado de definir el puerto por donde corre el programa
     *
     * @return variable de tipo int
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
