package app.toblerone;

import app.javache.api.RequestHandler;
import app.javache.http.HttpResponse;
import app.javache.http.HttpResponseImpl;
import app.javache.http.HttpStatus;
import app.javache.io.Reader;
import app.javache.io.Writer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TobleroneRequestHandler implements RequestHandler {

    private boolean hasIntercepted;

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) {
        try {
//            String requestContent = null;
//            int connectionReadTimer = 0;
//
//            while (connectionReadTimer < 5000) {
//                requestContent = Reader.readAllLines(inputStream);
//
//                if (requestContent.length() > 0) break;
//
//            }
//
//            if (requestContent == null || requestContent.length() < 1) {
//                throw new NullPointerException("BOOM");
//
//            }
//
//            byte[] responseContent = null;
//
//
            HttpResponse response = new HttpResponseImpl();
            response.setStatusCode(HttpStatus.OK);
            response.addHeader("Content-Type", "text/html");
            response.setContent("<h1>Hi</h1>".getBytes());
            hasIntercepted = true;
            Writer.writeBytes(response.getBytes(), outputStream);
        } catch (IOException e) {
            hasIntercepted = false;
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasIntercepted() {
        return this.hasIntercepted;
    }
}
