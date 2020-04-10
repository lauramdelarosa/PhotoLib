package com.delarosa.photolibexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delarosa.photolib.FaceDetector
import com.delarosa.photolib.models.Frame
import com.delarosa.photolib.models.Size
import com.otaliastudios.cameraview.Facing
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val faceDetector: FaceDetector by lazy {
        FaceDetector(facesBoundsOverlay)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCamera()
    }

    private fun setupCamera() {
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

        revertCameraButton?.setOnClickListener {
            cameraView.toggleFacing()
        }
    }

    override fun onResume() {
        super.onResume()
        cameraView.start()
    }

    override fun onPause() {
        super.onPause()
        cameraView.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraView.destroy()
    }
}
