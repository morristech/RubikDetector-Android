//
// Created by catalin on 26.07.2017.
//

#ifndef RUBIKDETECTORDEMO_COLORDETECTOR_HPP
#define RUBIKDETECTORDEMO_COLORDETECTOR_HPP

#include <memory>

namespace cv {
    class Mat;
}

class ColorDetectorBehavior;

class ImageSaver;

class ColorDetector {
public:
    ColorDetector();

    ColorDetector(std::shared_ptr<ImageSaver> imageSaver);

    ~ColorDetector();

    int detectColor(const cv::Mat &image, const float whiteRatio = 0.5f,
                    const int frameNr = -1, const int regionId = -1);

    void setDebuggable(const bool debuggable) const;

private:
    std::unique_ptr<ColorDetectorBehavior> colorDetectorBehavior;
};


#endif //RUBIKDETECTORDEMO_COLORDETECTOR_HPP
