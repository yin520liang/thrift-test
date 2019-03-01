namespace java yang.thrift.test.service
service Hello {
	string sayHello(1: string name)
	i32 visitorCount()
}