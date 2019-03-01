package yang.thrift.test.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import yang.thrift.test.service.Hello;

/**
 * Thrift Client
 *
 */
public class ThriftTestClient {

	public static void main(String[] args) {
		try {
			// server port: 9090
			TTransport transport = new TSocket("localhost", 9090, 3 * 1000);
			transport.open();
			// 设置传输协议为 TBinaryProtocol
			TProtocol protocol = new TBinaryProtocol(transport);
			Hello.Client client = new Hello.Client(protocol);
			System.out.printf("%s, you are the %d visitor.", 
						client.sayHello("Jim"), client.visitorCount());
			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

}
