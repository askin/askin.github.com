---
Title: Emacs Tramp SSH Hostname Tamamlama
Date: 2022-07-30T18:18:00+03:00
Author: Aşkın Özgür
Tags: ["emacs", "ssh"]
Slug: emacs-tramp-ssh-hostname-tamamlama
Status: published
---

`Ssh` ile baglandigim makineleri kategorilerine göre farklı dosyalarda tutup `~/.ssh/config` dosyasında `Include` ile tanımlıyorum.
Aşağıdaki gibi bir tanımlama güzel oluyor


```config
# ~/.ssh/ssh_config_company1
Host top-secret-prod-host
  Hostname prod.example.com
  User root
  
# ~/.ssh/ssh_config_company2
Host top-secret-dev-host
  Hostname dev.example.com
  User root

# ~/.ssh/config
Include ssh_config_company1
Include ssh_config_company2
```

Fakat `emacs tramp` ile sunuculara erişmeye çalıştığım zaman makine isimlerinin otomatik tamamlanmadığını farkettim.
İsmi tam yazıp bağlandığımda güzelce çalışıyor, fakat `TAB` ile tamamlamaya çalıştığımda bir tepki alamıyordum.
Biraz araştırdıktan sonra bir sonuç elde edemedim. Ya herkes bunun çözümünü biliyordu ya da ben doğru anahtar kelimeleri kullanmamıştım.
Sonunda ilgisizi bir stackoverflow postunda aşağıdaki kod parçasını gördüm. Denediğimde işe yaradı.

```elisp
(tramp-set-completion-function
 "ssh"
 '((tramp-parse-sconfig "/etc/ssh_config")
   (tramp-parse-sconfig "~/.ssh/config")))
```

Benzer bir problemde işinizi görebilir.
 

<!--more-->
