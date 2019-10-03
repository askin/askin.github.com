---
Title: Emacs ile bul değiştir / find and replace
Date: 2010-12-06T18:04:00+03:00
Author: askin
Category: Linux
Tags: ["emacs", "find", "Linux"]
Slug: emacs-ile-bul-degistir-find-and-replace
Status: published
---

    M-x
    replace-string RET aranan_string RET yerine_konulacak_string

Bunu regexli yapmak için replace-string yerine replace-regex kullanabilirsiniz.
Birde buna kısayol eklesek tadından yenmez.

.emacs dosyamıza aşağıdaki satırı ekliyoruz.

```lisp
;; Find and Replace
(global-set-key (kbd "C-q") 'replace-string)
```

C-q kombinasyonuna bastığımıza işlem başlamış oluyor.
