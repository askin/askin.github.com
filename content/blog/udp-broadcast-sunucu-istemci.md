---
Title: UDP Broadcast sunucu - istemci
Date: 2012-08-03T15:31:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: ["c/c++", "Linux", "network", "programming", "socket"]
Slug: udp-broadcast-sunucu-istemci
Status: published
---

Sunucu:

```c
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

#define MY_PORT 3333

int main(int argc, char *argv[])
{

    int sockfd, new_fd;
    struct sockaddr_in my_addr;    // hedef adres
    struct sockaddr_in their_addr; // baglanti yapan adres

    int sin_size, rt;

    // gelen verinin tutuldugu buffer
    char buf[32];

    // islem yapmak icin gerekli dosya gosterici
    sockfd = socket(AF_INET, SOCK_DGRAM, 0);

    sin_size = sizeof(struct sockaddr_in);

    // adres ile ilgili ayarlar
    my_addr.sin_family      = AF_INET;
    my_addr.sin_port        = htons(MY_PORT); // kullanilacak port
    my_addr.sin_addr.s_addr = INADDR_ANY;     // mevcut ip adresi
    memset(&(my_addr.sin_zero), 0, 8); // geri kalani 0la

    // socket ile dosyayi iliskilendir
    bind(sockfd, (struct sockaddr *)&my_addr, sizeof(struct sockaddr));

    while ( 1 ) {
        rt = recvfrom (sockfd, buf, 12, 0, (struct sockaddr *)&their_addr, &sin_size);
        if (rt > 0) {
            printf ("recv: %s\n", buf);
        } else if (rt < 0) {
            printf("Baglanti koptu\n");
            break;
        }
    }

    close(sockfd);
    return 0;
}
```

İstemci:

```c
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

#define DEST_IP   "255.255.255.255"
#define DEST_PORT 3333

int main(int argc, char *argv[])
{

    int sockfd, new_fd;
    struct sockaddr_in dest_addr; // hedef adres

    int sin_size, rt;
    sin_size = sizeof(struct sockaddr_in);

    // islem yapmak icin gerekli dosya gosterici
    sockfd = socket(AF_INET, SOCK_DGRAM, 0);

    // adres ile ilgili ayarlar
    dest_addr.sin_family      = AF_INET;
    dest_addr.sin_port        = htons(DEST_PORT);
    dest_addr.sin_addr.s_addr = inet_addr(DEST_IP);
    memset(&(dest_addr.sin_zero), 0, 8); // geri kalani 0 la

    // Broadcast icin gerekli yetkiyi al
    int flag = 1;
    if (setsockopt (sockfd, SOL_SOCKET, SO_BROADCAST, &flag, sizeof(flag)) < 0)
        perror("setsockopt");

    // mesaji gonder
    rt = sendto (sockfd, "slm asl plz", 12, 0, (const struct sockaddr *)&dest_addr, sin_size);
    if ( rt < 0 )
        perror("Hata: ");

    // socketi kapat
    close(sockfd);

    return 0;
}
```
