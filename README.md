# androidtestcompileexclude
Demonstrates an apparent problem with Android Studio 3.0 Canary 4 and/or Gradle

Clone repo, which creates folder androidtestcompileexclude
Open this folder (master branch) in Android Studio 2.3
Right click on 'ExampleInstrumentedTest' & select 'Run'
Both tests should pass.
Close Android Studio 2.3

In folder androidtestcompileexclude: git checkout .; git checkout studio3
Open androidtestcompileexclude with Android Studio 3.0 Canary 4
Right click on 'ExampleInstrumentedTest' & select 'Run'
1 test should fail, reporting that 'org.threeten.bp.zone.ZoneRulesException: No time-zone data files registered'

This same error can occur in the 2.3 version if the following 3 lines are commented out in app/build.gradle:
androidTestImplementation("org.threeten:threetenbp:1.3.3") {
   exclude group: 'com.jakewharton.threetenabp', module: 'threetenabp'
}
(see comment above these lines for why this exclude is necessary)

Implication is that the following form is *not* working in Android Studio 3.0 Canary 4 with com.android.tools.build:gradle:3.0.0-alpha4
androidTestImplementation("org.threeten:threetenbp:1.3.3") {
   exclude group: 'com.jakewharton.threetenabp', module: 'threetenabp'
}
