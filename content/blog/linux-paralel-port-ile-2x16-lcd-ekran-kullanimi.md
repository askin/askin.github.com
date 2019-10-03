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

<p>
<script src="https://gist.github.com/3743456.js"> </script>
</p>
Linke birşey olması durumunda [bu adresten gerekli şemayı indirebilirsiniz.](/uploads/2011/02/parlcd.gif)
