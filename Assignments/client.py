import socket               # Import socket module

s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 12121       # Reserve a port for your service.
s.connect(3001);
print(s.recv(1024))
flag1=0

while (flag1!=1):
	print("Enter message")
	a=input()
	a1=bytes(a, 'utf-8')
	s.send(a1)
	print("Do u Want To stop enter (1) else (0)")
	flag1=int(input())
	


s.close();
