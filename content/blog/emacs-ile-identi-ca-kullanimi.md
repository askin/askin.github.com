---
Title: Emacs ile identi.ca kullanımı
Date: 2013-03-04T11:55:00+03:00
Author: Aşkın Özgür
Category: Günlük
Tags: ["emacs"]
Slug: emacs-ile-identi-ca-kullanimi
Status: published
---

Identi.ca hesabini emacs ile takip etmek çok basit ve eğlenceli. identica-mode kullanarak identi.ca hesabini takip edebiliyoruz. identica-mode elpa ya da marmalade deposunda bulunmuyor. Bunun için eski yöntemle kurmak gerek.

Öncelikle gerekli dosyaları gerekli yerlere indiriyoruz(git deposundan alacağım).

    cd ~/.elisp
    git clone http://git.savannah.gnu.org/cgit/identica-mode.git

Şimdi .emacs dosyamıza gerekli satırları ekleyelim.

    (setq load-path (cons "~/.elisp/identica-mode" load-path))
    (require 'identica-mode)
    (setq identica-username "userName")

Parolasız giriş yapabilmek için *\~/.authinfo* adinda bir dosya olusturup içini aşağıdaki gibi dolduralım.

    machine identi.ca login kullaniciAdi password parola
