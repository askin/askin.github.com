---
Title: Emacs Fill Column Indicator
Date: 2020-08-25
Author: Aşkın Özgür
Category: Emacs
Tags: ["emacs"]
Status: published
---

Editörde 80. kolonun nerede bittiğini görmek için [Alp Aker](https://github.com/alpaker) tarafından yazılmış olan 
[fill-column-indicator](https://github.com/alpaker/fill-column-indicator)
kullanıyordum. Emacs 27.0.90 ile birlikte bu özellik yerleşik gelmeye başladı.

Aşağıdaki kodu .emacs dosyanıza ekleyerek versiyona göre uygun fill-column-indicator kullanabilirsiniz.

```elisp
(if (version< emacs-version "27.0.90")
    (add-hook 'prog-mode-hook #'fci-mode)
  (global-display-fill-column-indicator-mode))
```

Eğer 80 karekter yetmiyorsa aşağıdaki kodla 120 karektere çıkartabilirsiniz.

```elisp
(setq-default fill-column 120)
```

___


![Fill Column Indicator Preview](/uploads/2020/08/emacs-fill-column-indicator.png)
