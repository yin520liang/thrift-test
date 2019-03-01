package yang.thrift.test.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.thrift.TException;

public class HelloServiceImpl implements Hello.Iface {
	
	private static final AtomicInteger counter = new AtomicInteger(0);

	@Override
	public String sayHello(String name) throws TException {
		return "Hello, " + name;
	}

	@Override
	public int visitorCount() throws TException {
		return counter.incrementAndGet();
	}

}
