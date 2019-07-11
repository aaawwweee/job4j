package io;
import org.junit.Test;
import socket.Server;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerTest {
    private static final String LN = System.getProperty("line.separator");
    @Test
    public void whenExit() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("exit".getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.server();
        assertThat(out.toString(), is(""));
    }
    @Test
    public void whenAskHelloThenHelloBackByOracle() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                String.format(
                        "Hello, oracle%sexit",
                        LN
                ).getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.server();
        assertThat(out.toString(), is(
                String.format("Hello, dear friend, I'm oracle.%s%s", LN, LN)));
    }
}
