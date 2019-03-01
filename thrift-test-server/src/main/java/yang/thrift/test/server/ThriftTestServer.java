package yang.thrift.test.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import yang.thrift.test.service.Hello;
import yang.thrift.test.service.HelloServiceImpl;

public class ThriftTestServer {
	private static final int port = 9090;

	public static void main(String[] args) {		
		TServer server = null;
		try {
			TProcessor processor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
			TServerTransport serverTransport = new TServerSocket(port);
			// binary protocol
			Factory proFactory = new TBinaryProtocol.Factory();
			server = new TThreadPoolServer(
								new TThreadPoolServer.Args(serverTransport)
								.processor(processor)
								.protocolFactory(proFactory));
			System.out.println("Start the thrift server...");
			server.serve();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(server != null) {
				System.out.println("Stop the thrift server...");
				server.stop();
			}
		}
	}

}
