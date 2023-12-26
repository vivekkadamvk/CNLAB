
import socket               # Import socket module

s = socket.socket()         # Create a socket object
host = socket.gethostname() # Get local machine name
port = 12121        # Reserve a port for your service.
s.bind((host, port))        # Bind to the port

s.listen(1  )# Now wait for client connection. a= "Thank you for connecting"
a1: bytes = bytes(a, 'utf-8')
flag1 = 0

c, addr = s.accept()  # Establish connection with client.
print("Got connection from", addr)
c.send(a1)
while (flag1 != 1):
    obj = c.recv(1024)
    print("Message Form Client Is:--- ", obj.decode('ASCII'))
    print("Do u Want To stop  Receiving enter (1) else (0)")
    flag1 = int(input())
c.close()
