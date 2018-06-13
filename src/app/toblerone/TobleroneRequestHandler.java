package app.toblerone;

import app.javache.api.RequestHandler;

import java.io.InputStream;
import java.io.OutputStream;

public class TobleroneRequestHandler implements RequestHandler {

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) {

    }

    @Override
    public boolean hasIntercepted() {
        return false;
    }
}
