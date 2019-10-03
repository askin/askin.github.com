---
Title: Alın size bir güzel kod:)
Date: 2007-12-28T16:29:00+03:00
Author: askin
Category: Programlama
Tags: []
Slug: alin-size-bir-guzel-kod
Status: published
---

Alın size bir güzel kod:) Benim hoşuma gitti eminim sizin hoşunuzada gidecek.

```scheme
(define (goster str)
  (let loop ((str str))
    (if (equal? str "")
        (begin
          (sleep 0)
          (display ""))
        (begin
          (sleep 1/2)
          (display (string-ref str 0))
          (loop (substring str 1))))))
```
