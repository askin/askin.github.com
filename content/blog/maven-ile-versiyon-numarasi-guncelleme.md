---
title: Maven İle Versiyon Numarası Güncelleme
date: 2021-11-03T19:04:25+03:00
Author: Aşkın Özgür
Category: ["Programlama"]
Tags: ["Maven", "Programlama"]
Slug: maven-ile-versiyon-numarasi-guncelleme
draft: false
---

Bir `maven` projeniz varsa ve versiyon numarasını güncellemek istiyorsanız, `pom.xml`i bir editör ile açıp versiyon numarasını güncelleyebileceğiniz gibi, maven kullanarak da bunu yapabilirsiniz.

Aşağıdaki gibi bir `pom.xml` dosyaminizin olduğunu düşünelim.

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.mycompany.app</groupId>
  <artifactId>my-app</artifactId>
  <version>1.0.0</version>

  <name>my-app</name>
</project>
```

Aşağıdaki komut ile `1.0.0` olan versiyon numarasını `1.0.5` olarak güncelledik.
```sh
mvn versions:set -DnewVersion=1.0.5 versions:commit
```

Eğer otomatik olarak versiyon numarasını yükseltmek istersek aşağıdaki komut işimizi görecek.

```sh
mvn build-helper:parse-version versions:set \
    -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion} \
    versions:commit
```

Artık versiyon numaramız `1.0.6`

Minör versiyon yükseltmek isterseniz

```sh
mvn build-helper:parse-version \
    versions:set \
    -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.nextMinorVersion}.\${parsedVersion.buildNumber} \
    versions:commit
```

Major versiyon yükseltmek isterseniz

```sh
mvn build-helper:parse-version versions:set \
    -DnewVersion=\${parsedVersion.nextMajorVersion}.0.0 \
    versions:commit
```

Daha detaylı bilgi için aşağıdaki linki kullanabilirsiniz.

[https://www.mojohaus.org/build-helper-maven-plugin/parse-version-mojo.html](https://www.mojohaus.org/build-helper-maven-plugin/parse-version-mojo.html "Build Helper Maven Plugin")

<!--more-->
