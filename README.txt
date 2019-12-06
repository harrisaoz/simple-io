# Known Issues

Currently, tests fail to run after converting this to produce a JPMS module.
In order to run tests:
- remove src/main/java/au.id.ah.sio/module-info.java
- move src/main/java/au.id.ah.sio/au to src/main/java
