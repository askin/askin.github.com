---
Title: Linux, Paralel Port ile 2x16 LCD Ekran Kullanımı
Date: 2011-02-27T03:08:00+03:00
Author: askin
Category: Programlama
Tags: ["c", "lcd", "liux", "parallel port"]
Slug: linux-paralel-port-ile-2x16-lcd-ekran-kullanimi
Status: published
---

Çalıştığım projede linuxta paralel port ile lcd ekran kullanmam gerekti. Neredeyse internetin altını üstüne getirdim ama işime yarar çok birşey bulamadım. Sonunda DOS için yazılmış bir kod buldum. Bu kodu biraz inceleyip, gerekli püf noktaları bulunca kodu linux'a uydurmak çok zor olmadı. Hatta neredeyse sadece kullanılan fonksiyonun adını ve parametre yerlerini değiştirdim :)

Aslında olay çok basitmiş, lcd ekrandan çıkan 14 bacaktan, 8tanesini data ve komut göndermek için kullanıyoruz. 1 bacak enable, 1 set - reset seçimi için, 1 bacakta read/write seçimi için kullanılıyor. Geri kalan 3 bacak güç bağlantısı ve kontrast için kullanılıyor. [Burdaki](http://www.beyondlogic.org/parlcd/parlcd.htm) şemaya göre bağlantıları yapabilirsiniz. Ayrıca örnek aldığım kodda aynı sayfada bulunmakta.

Yorum satırları pek çok şeyi açıklıyor. Ama birkaç noktaya değinmekte fayda var. Data bacaklarına gerekli inputları verdikten sonra, enable bacağını 1'den 0'a düşürerek lcd'nin data bacaklarında sinyali alıp işleme sokmasını sağlıyoruz. init array'i içinde lcd'nin temizlenmesi ve çalışmaya uygun hale gelmesi için gerekli komutlar tutuluyor. 0x378 paralel portun adresi.

```c
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <asm/io.h>

#define PORTADDRESS 0x378  /* Enter Your Port Address Here */

#define DATA PORTADDRESS+0
#define STATUS PORTADDRESS+1
#define CONTROL PORTADDRESS+2

int main()
{
    if (ioperm(DATA , 3, 1)) {perror("ioperm"); exit(1);}
    char string[] = {"Testing 1,2,3                           "
                     "It' Works !                             "};

    char init[10];
    int count;
    int len;
    init[0] = 0x0F; /* Init Display */
    init[1] = 0x01; /* Clear Display */
    init[2] = 0x38; /* Dual Line / 8 Bits */

    outb(inb(CONTROL) & 0xDF, CONTROL); /* Reset Control Port - Make sure Forward Direction */
    outb(inb(CONTROL) | 0x08, CONTROL); /* Set Select Printer (Register Select) */

    for (count = 0; count < = 2; count++)
    {
        outb(init[count], DATA);
        outb(inb(CONTROL) | 0x01, CONTROL); /* Set Strobe (Enable)*/
        usleep(20);                                 /* Larger Delay for INIT */
        outb(inb(CONTROL) & 0xFE, CONTROL); /* Reset Strobe (Enable)*/
        usleep(20);                                 /* Larger Delay for INIT */
    }

    outb(inb(CONTROL) & 0xF7, CONTROL);  /* Reset Select Printer (Register Select) */

    len = strlen(string);

    for (count = 0; count < len; count++)
    {
        outb(string[count], DATA);
        outb(inb(CONTROL) | 0x01, CONTROL); /* Set Strobe */
        usleep(2);
        outb(inb(CONTROL) & 0xFE, CONTROL); /* Reset Strobe */
        usleep(2);
    }

    return 0;
}
```

Linke birşey olması durumunda [bu adresten gerekli şemayı indirebilirsiniz.](/uploads/2011/02/parlcd.gif)
