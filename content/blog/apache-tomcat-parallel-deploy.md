---
Title: Apache Tomcat Paralel Deploy
Date: 2020-09-12
Author: Aşkın Özgür
Category: Linux
Tags: [tomcat, deploy, maven]
Status: published
---

Apache Tomcat kullanıyorsanız aynı uygulamanın birden fazla sürümünü
aynı anda aynı path üzerinde çalıştırabilirsiniz. Bu deploy yaparken
kesintisiz hizmet sağlamak için çok yardımcı oluyor. Buna **Parallel
Deployment** deniyor. Paralel deploy sırasında eğer uygulamanın bir
önceki versiyonunda oturum açılmışsa istekler oraya gitmeye devam
ediyor, yeni oturumlar yeni sürüme gitmeye başlıyor.

<!--more-->

Paralel deploy yapabilmek için oluşturulan `war` dosyasının bir
versiyona sahip olması gerekmekte. Bunu yapabilmek için dosya ismini
`paket-ismi##VERSION.war` şeklinde yapmak gerekiyor. Eğer **Maven**
kullanıyorsanız `pom.xml` dosyasında aşağıdaki gibi basitçe
yapabilirsiniz.

```xml
<build>
    <finalName>${project.artifactId}##{$project.version}</finalName>
</build>
```

Eğer version numarasından ziyada derleme zamanını kullanmak isterseniz
aşağıdaki gibi yapabilirsiniz.

```xml
<build>
    <finalName>${project.artifactId}##${maven.build.timestamp}</finalName>
</build>
```

Böyle bir durumda `paket-ismi##2020-09-12T12:17:40Z.war` gibi bir
dosya ismi oluşacaktır, bu bana çirkin görünüyor. Daha düzgün bir tarih
formatı için aşağıdaki gibi bir kullanım iş görecektir.

```xml
<properties>
    <maven.build.timestamp.format>yyMMdd_HHmm</maven.build.timestamp.format>
    <buildNumber>${maven.build.timestamp}</buildNumber>
</properties>

<build>
    <finalName>${project.artifactId}##${buildNumber}</finalName>
</build>
```

Fakat bu kullanımda *TIMEZONE* *muhtemelen* **UTC** olacaktır. Bunun
önüne geçmek için aşağıdaki gibi bir kullanım işinizi çözecektir.

```xml
<build>
    <finalName>${project.artifactId}##${build.time}</finalName>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>build-helper-maven-plugin</artifactId>
            <version>1.10</version>
            <executions>
                <execution>
                    <id>timestamp-property</id>
                    <goals>
                        <goal>timestamp-property</goal>
                    </goals>
                    <configuration>
                        <name>build.time</name>
                        <pattern>yyyyMMddHHmmss</pattern>
                        <timeZone>Asia/Istanbul</timeZone>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

Artık deploy yaparken bir önceki `war` dosyasını silmeden yeni
dosyanızı atabilirsiniz. Eğer yapılan deployu geri almak isterseniz
attığınız son dosyayı silmek yeterli olacaktır.

Kaynaklar:
* [https://tomcat.apache.org/tomcat-8.5-doc/config/context.html#Parallel_deployment](https://tomcat.apache.org/tomcat-8.5-doc/config/context.html#Parallel_deployment "https://tomcat.apache.org/tomcat-8.5-doc/config/context.html#Parallel_deployment")
