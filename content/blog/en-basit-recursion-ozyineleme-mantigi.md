---
Title: En basit recursion - özyineleme mantığı
Date: 2007-10-26T16:09:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: []
Slug: en-basit-recursion-ozyineleme-mantigi
Status: published
---

Benin algılamakta en zorluk çektiğim kavramdı. Ancak öğrenince çok çok işe yarıyor.

```scm
(define
  (lst-length lst)
  (if (null? lst)
      0
      (+ 1 (lst-length (cdr lst)))))
```

Kodu tanımlayacak olursak (null? lst) lst değişkeninde tuttuğumuz listenin boş olup olmadığını kontrol ediyor. Boş listenin eleman sayısının 0 olduğunu biliyoruz. Listemiz genelde ilk halinde boş olmayacağı için if condition direk \#f verip 2. satıra geçecek. özyinelemenin can damarı aslında burda. Biz 1 eksik elemanlı listenin eleman sayısıyla 1i topluyoruz. Sonra tekrar 1 eksik elemanlı listenin 1 elemanını daha çıkartıp, o listenin eleman sayısıyla topluyoruz. Taki (null? lst) \#t olana kadar. Ozamanda zaten fonkiyon 0 verecek ve tüm o 1leri toplayacak. size tavsiyem bu konu hakkında çok düşüünün elinizde olan örnekleri tekrar tekrar uygulayın.
