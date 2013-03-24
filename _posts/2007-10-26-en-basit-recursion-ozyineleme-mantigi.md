---
layout: post
title: "En basit recursion - Özyineleme mantığı"
published: true
meta:
  _edit_last: "1"
tags:
- AQ
- programlama
- scheme
type: post
status: publish
---
Benin algılamakta en zorluk çektiğim kavramdı. Ancak öğrenince çok çok işe yarıyor.

    (define (lst-length lst)
      (if (null? lst)
          0
          (+ 1 (lst-length (cdr lst)))))

Kodu tanımlayacak olursak _(null? lst)_ lst değişkeninde tuttuğumuz listenin boş olup olmadığını kontrol ediyor. Boş listenin eleman sayısının _0_ olduğunu biliyoruz. Listemiz genelde ilk halinde boş olmayacağı için if condition direk _#f_ verip 2. satıra geçecek. özyinelemenin can damarı aslında burda. Biz _1_ eksik elemanlı listenin eleman sayısıyla 1i topluyoruz. Sonra tekrar 1 eksik elemanlı listenin 1 elemanını daha çıkartıp, o listenin eleman sayısıyla topluyoruz. Taki _(null? lst) #t_ olana kadar. Ozamanda zaten fonkiyon 0 verecek ve tüm o 1leri toplayacak. size tavsiyem bu konu hakkında çok düşüünün elinizde olan örnekleri tekrar tekrar uygulayın.
