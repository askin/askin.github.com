---
Title: C ile Nesne Yaratmak
Date: 2010-04-27T04:08:00+03:00
Author: askin
Category: Programlama
Tags: ["c/c++", "Nesne", "OOP"]
Slug: c-ile-nesne-yaratmak
Status: published
---

![](/uploads/2010/04/c3po.jpg "C-3PO")Evet kışkırtıcı bir başlık attım :)
Aslında yapacağımız olay bir structı nesne gibi kullanmak. Buna benzer bir kodu yıllar önce görmüştüm. O günden bu güne sürekli böyle bir şeyi nasıl yaparım diye araştırdım. Anca bugün çözebildim olayı ;)
Kodu aşağıda yorum satırıyla beraber veriyorum. Yorumlarda gerekli açıklamaları yaptım.

Bu yazıyla C-3PO nun ne lakası var diyebilirsiniz. C ile resim ararken karşıma bu çıktı, bende boş durmasın dedim :)

```c
/*
 * Sınıfımızı yaratıyoruz
 */
struct _myobject {
  // alt alanlar
  int a, b;
  /*
   * Metod
   * Burada fonksiyon pointerı tanımlıyoruz
   */
  int (*add)(struct _myobject*);
};

// struct ön ekinden kurtuluyoruz
typedef struct _myobject MyObject;

/*
 * Asıl işi yapacak fonksiyonu tanımlıyoruz
 * MyObject structını parametre olarak alıyor
 */
int realAdd(MyObject* a) {
  return a->a + a->b;
}

int main ( void ) {
  /*
   * Nesnemizi oluşturuyoruz.
   * add pointerına fonksiyonu atıyoruz
   */
  MyObject mo = {1, 2, realAdd};
  printf("A + B = %d\n", mo.add(&mo));
  return 0;
}
```

Kodun başına stdio.h headerını eklemekte fayda var. WP sıkıntı çıkarttığı için silmek zorunda kaldım. Kodun düzgün halini [burada](http://github.com/askin/misc/raw/master/fun/struct-function.c) bulabilirsiniz.
