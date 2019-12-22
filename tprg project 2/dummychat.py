# dummychat.py -- test chat terminal for TPRG2131 F2019 Project 2
# Reply to CONNECTREQ and chat messages from a terminal. This is
# used to test the terminal that initiates the conversation in the
# Project 2 communication system.
#
# Run this from PowerShell (Windows) or bash (Linux)
#
# The response is "hard coded" to reply to the messages sent by
# the terminal being tested. See the message definitions in the
# project documentation.
#
# Client-server examples based on tutorial by Nathan Jennings
#  https://realpython.com/python-sockets/
#

import json  # serialize data 
import socket  # low level networking (Berkeley sockets)

# For testing on your own system, use the loopback interface
LOCALHOST = "127.0.0.1"  # loopback address, a.k.a. localhost

HOST = LOCALHOST  # leave as empty string to use my own IPv4 address 
PORT = 8085  # Terminal listens for chat requests on 8085 (server is 8082)


def log(s):
    """Print the argument if testing/tracing is enabled."""
    if TESTING:
        with open("logfile.txt", "a") as logfile:
            print("dummychat:", s, file=logfile)


##
# Main
## 

# Create a new socket for address family IPv4, TCP protocol (Stream)
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# Bind that socket to a specific address and port number on the machine
sock.bind((HOST, PORT))
# This socket is configured for listening for incoming connections
sock.listen()

while True:
    # wait for a connection request and accept it.
    # when the connection is made, conn is a connection object and
    # addr is the (IP address, port) of the client that is connecting.
    conn, addr = sock.accept()

    # The with statement creates a context
    # conn will be closed when the context ends; we don’t need conn.close()
    with conn:
        # Append basic connection info to a local log file
        with open("logfile.txt", "a") as logfile:
            print("Connection from", addr, file=logfile)
        # Phase 1: receive a connect request from the other terminal.
        data = conn.recv(1024)
        if not data:
            continue
        recv_string = data.decode("UTF-8")  # make a Python Unicode string
#            print("Data:", recv_string)
        recv_dict = json.loads(recv_string)  # make a Python dictionary
       # for k in recv_dict:   # optional: dump out the key:value pairs
           # print(k, recv_dict[k])
        if recv_dict["msgtype"] == "CONNECTREQ":
            # Always grant the request (normally there would be a lookup)
            reply = json.dumps({
                                "msgtype": "CONNECTREPLY",
                                "status": "ACCEPTED"
                                })
            conn.sendall(reply.encode("UTF-8"))  # send to client as UTF-8
            print("Connect request accepted from", addr)
            # And now the chat begins: receive data from the other side and echo
            # until the connection is broken
            while True:
                data = conn.recv(1024)
                if not data:
                    break
                recv_string = data.decode("UTF-8")  # make a Python Unicode string
                print("recv:", recv_string)
                conn.sendall(recv_string.encode("UTF-8"))  # echo to other side as UTF-8

# Done!
sock.close() # (Actually should use another with statement!)
print("Socket closed. Bye!")
