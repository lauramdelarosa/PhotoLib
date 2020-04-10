# PhotoLib


## Usage

Three easy steps:

1. Add a `FaceBoundsOverlay` on top of your camera view.
```xml
<FrameLayout
    ...>

    // Any other views

    <CameraView
        ... />

    <com.delarosa.photolib.FaceBoundsOverlay
        ... />

    // Any other views

</FrameLayout>
```

2. Define a `FaceDetection` instance and connect it to your camera.
```kotlin
private val faceDetector: FaceDetector by lazy {
    FaceDetector(facesBoundsOverlay)
}

...

 cameraView.addFrameProcessor { camera ->
            faceDetector.process(
                Frame(
                    data = camera.data,
                    rotation = camera.rotation,
                    size = Size(camera.size.width, camera.size.height),
                    format = camera.format,
                    isCameraFacingBack = cameraView.facing == Facing.BACK
                )
            )
        }
```

3. [Setup firebase](https://firebase.google.com/docs/android/setup) in your Android project


## Download
1. Add the code below in your root build.gradle at the end of repositories
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
2. Add the dependency
```groovy
 implementation 'com.github.lauramdelarosa.PhotoLib:photolib:0.2.2'
```

[![](https://jitpack.io/v/lauramdelarosa/PhotoLib.svg)](https://jitpack.io/#lauramdelarosa/PhotoLib)


![](example.gif)
