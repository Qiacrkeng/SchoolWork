from asyncio.windows_events import NULL
import cv2

filepath = r'./1482293965281.jpg'
image = cv2.imread(filepath)
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
# 路径为python模块下的xml
classfier = cv2.CascadeClassifier(
    r'D:/Python language/Lib/site-packages/cv2/data/haarcascade_frontalface_default.xml'
)
faceRect = classfier.detectMultiScale(gray,
                                      scaleFactor=1.6,
                                      minNeighbors=3,
                                      minSize=(50, 50))
if len(faceRect):
    for face in faceRect:
        x, y, w, h = face
        cv2.rectangle(image, (x, y), (x + w, y + h), (0, 255, 0), 2)

cv2.imshow("image", image)
cv2.waitKey(0)
cv2.destroyAllWindows()
