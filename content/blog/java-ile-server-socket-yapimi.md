---
Title: Java ile server socket yapımı
Date: 2010-12-11T04:25:00+03:00
Author: askin
Category: Programlama
Tags: ["Java", "server", "socket", "telnet"]
Slug: java-ile-server-socket-yapimi
Status: published
---

Bir proje için server sockete ihtiyaç duydum. Öncelikli dilim python olmasına rağmen, sunucu solaris olunca java ile yazmak daha cazip geldi. Öncelikli olarak test amaçlı birkaç satır kod yazdım. Akla gelen ilk örnek echo server oluyor :) aşağıda multi thread çalışan, birden fazla kullanıcıya cevap verebilecek bir echo server var:)

*Server.java*

```java
/**
 * @author: Aşkın Yollu 
 */

import java.net.*;
import java.io.*;

class Server {
    public static void main(String args[]) throws Exception {
        ServerSocket myService = null;
        Socket       client    = null;
        Worker       tmpworker = null;
        
        try {
            // 1234 nolu portu dinle
            myService = new ServerSocket(1234);
        } catch (IOException e) {
            System.out.println(e);
        }


        try {
            while (true) {
                // bağlantı kuracak istemcileri bekle
                client = myService.accept();

                // bağlantıları bir listeye ekle

                // istemci için yeni thread oluştur
                tmpworker = new Worker(client);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
```

*Worker.java*

```java
/**
 * @author: Aşkın Yollu
 */

import java.net.*;
import java.io.*;

class Worker implements Runnable {
    private Socket           client;
    private DataInputStream  is;
    private DataOutputStream os;
    Thread       t;

    // Yaratıcı method
    public Worker(Socket client) {
        this.client = client;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        String line = null;
        
        try {
            this.is = new DataInputStream(this.client.getInputStream());
            this.os = new DataOutputStream(this.client.getOutputStream());

            while (true) {
                line =this.is.readLine();
                this.os.writeBytes(line + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
```

kodları derleyip çalıştırdıktan sonra

```bash
telnet localhost 1234
```

komutunu verip birşeyler yazmaya başlayın, bakalım ne olacak :)

Client tarafını c ile yazacağım. Muhtemelen bir sonraki girdi c ile client socket olur.
