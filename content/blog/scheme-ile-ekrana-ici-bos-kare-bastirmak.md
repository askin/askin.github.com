---
Title: Scheme ile ekrana içi boş dikdörtgen bastırmak
Date: 2007-12-20T09:13:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: []
Slug: scheme-ile-ekrana-ici-bos-kare-bastirmak
Status: published
---

```scheme
(define (kare x y)
  (do ((i 0 (+ i 1))) ((= i x))
    (newline)
    (do ((j 0 (+ j 1))) ((= j y))
      (if (or (= i 0) (= i (- x 1)))
          (display "*")
          (if (or (= j 0) (= j (- y 1)))
              (display "*")
              (display " "))))))
```

bu kod aşağıdaki gibi bir şekil oluşruracak

```scheme
**********
*        *
*        *
*        *
*        *
*        *
*        *
*        *
*        *
**********
```

Ancak bu şekil pek hoş değil. Eğer display'in içini biraz düzenlersek çok dahahoş şekilerle karşılaşırız.

```scheme
(define (kare x y)
  (do ((i 0 (+ i 1))) ((= i x))
    (newline)
    (do ((j 0 (+ j 1))) ((= j y))
      (if (or (= i 0) (= i (- x 1)))
          (display "* ")
          (if (or (= j 0) (= j (- y 1)))
              (display "* ")
              (display "  "))))))
```

Bu kod

```scheme
* * * * * * * * * * 
*                 * 
*                 * 
*                 * 
*                 * 
*                 * 
*                 * 
*                 * 
*                 * 
* * * * * * * * * *
```

şeklini oluşturacaktır. Tabiki etkileşim penceresinde şekil daha düzgün çıkacaktır.

<!--more-->
