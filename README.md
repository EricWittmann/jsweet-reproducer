# jsweet-reproducer
Reproduces a jsweet build problem/regression.

Steps to reproduce:

```
$ git clone https://github.com/EricWittmann/jsweet-reproducer.git
$ cd jsweet-reproducer
$ mvn clean install -Ptranspilation
$ Open chrome using: chrome.exe --allow-file-access-from-file
$ Open the target/test.html file in the above Chrome
$ View (above screenshotted) output in browser js console
```

If you change the version to 2.3.5 and repeat step (3) above, then reload the browser, there will be no failure.
