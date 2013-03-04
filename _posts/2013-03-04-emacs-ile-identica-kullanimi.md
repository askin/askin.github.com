---
layout: post
title: "Emacs ile identi.ca kullanımı"
published: true
tags:
- identica
- emacs
type: post
status: publish
---
Identi.ca hesabini emacs ile takip etmek çok basit ve eğlenceli. identica-mode kullanarak identi.ca hesabini takip edebiliyoruz. identica-mode elpa ya da marmalade deposunda bulunmuyor. Bunun için eski yöntemle kurmak gerek.

Öncelikle gerekli dosyaları gerekli yerlere indiriyoruz(git deposundan alacağım).

    cd ~/.elisp
    git clone http://git.savannah.gnu.org/cgit/identica-mode.git

Şimdi .emacs dosyamıza gerekli satırları ekleyelim.

    ;; identica mode
    (setq load-path (cons "~/.elisp/identica-mode" load-path))
    (require 'identica-mode)
    (setq identica-username "userName")

Parolasız giriş yapabilmek için _~/.authinfo_ adinda bir dosya olusturup içini aşağıdaki gibi dolduralım.

    machine identi.ca login kullaniciAdi password parola
