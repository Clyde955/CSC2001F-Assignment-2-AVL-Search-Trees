

JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes:  bin/BinaryTreeNode.class bin/BinaryTree.class\
         bin/BTQueueNode.class bin/BTQueue.class \
		 bin/AVLTree.class bin/LSAVLTApp.class \
		 bin/BinarySearchTree.class bin/LSBSTApp.class\
		 bin/lsObject.class \
         
		
		 


default: $(CLASSES)

clean:
	rm *.class
