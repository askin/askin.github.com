---
Title: Var olan bir SVN deposunun adresini değiştirme
Date: 2012-04-09T10:48:00+03:00
Author: askin
Category: Programlama
Tags: ["Programlama", "programming"]
Slug: var-olan-bir-svn-deposunun-adresini-degistirme
Status: published
---

Herhangi bir nedenle üzerinde çalıştığınız svn deposunun adresi değişirse aşağıdaki komutla gerekli değişikliği yapabilirsiniz.

`svn switch --relocate http://svn.example.com/path/to/repository/path/within/repository http://svnnew.example.com/new/repository/path/within/repository`
