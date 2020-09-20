import sys
from PyQt5.QtGui import QPixmap
from PyQt5 import QtCore, QtGui, QtWidgets, uic
from decimal import Decimal

from pyfirmata import Arduino, util

board = Arduino('COM3')
qtcreator_file  = "introWindow.ui"
Ui_MainWindow, QtBaseClass = uic.loadUiType(qtcreator_file)


class MyWindow(QtWidgets.QMainWindow, Ui_MainWindow):
    def __init__(self):
        QtWidgets.QMainWindow.__init__(self)
        Ui_MainWindow.__init__(self)
        self.setupUi(self)
        self.cButton.clicked.connect(self.completed)
        self.sButton.clicked.connect(self.skipped)
        
    def completed(self):
        counter = int(self.count.text())
        if(counter<8):
            counter = counter + 1
        self.count.setText(str(counter))
        board.digital[counter+1].write(1)
        self.inputBox.clear()

        img = "step{}.png".format(counter+1)
        pixmap = QPixmap(img)
        self.picLabel.setPixmap(pixmap)

        

    def skipped(self):
        counter = int(self.count.text())
        board.digital[counter+1].write(0)
        self.inputBox.clear()

        counter = counter - 1
        self.count.setText(str(counter))

        img = "step{}.png".format(counter+1)
        pixmap = QPixmap(img)
        self.picLabel.setPixmap(pixmap)

        

if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    window = MyWindow()
    window.show()
    sys.exit(app.exec_())
