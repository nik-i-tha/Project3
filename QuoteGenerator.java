import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;       //HTTP server implementation
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class QuoteGenerator {
  private static final String[] quotes = {
  };

  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0); //Binds the server to the network interface on port 8080 0-default value
    server.createContext("/random-quote", new QuoteHandler());   //Defines context for server with the path "/random-quote" and with an instance of the QuoteHandler class.
    server.setExecutor(null);
    server.start();
    System.out.println("Server started on port 8080");
  }

   static class QuoteHandler implements HttpHandler {           //handling incoming HTTP requests to the "/random-quote" 
    @Override
    public void handle(HttpExchange exchange) throws IOException {       //how the server responds to incoming requests.
      String randomQuote = getRandomQuote();                              //retrieve a random quote from the quotes array

      exchange.getResponseHeaders().set("Content-Type", "text/plain");         //response will contain plain text data.
      exchange.sendResponseHeaders(200, randomQuote.length());

      try (OutputStream responseBody = exchange.getResponseBody()) {
        responseBody.write(randomQuote.getBytes());                                //This sends the quote data back to the client.
      }
    }
  }

  private static String getRandomQuote() {
    int randomIndex = (int) (Math.random() * quotes.length);
    return quotes[randomIndex];
  } 
}