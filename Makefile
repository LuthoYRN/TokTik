JAVAC = /usr/bin/javac
SRCDIR = src
BINDIR = bin
DOCDIR = doc

.SUFFIXES: .java .class

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR) -cp $(BINDIR) $<

CLASSES = $(BINDIR)/Post.class $(BINDIR)/TikTokPost.class $(BINDIR)/Account.class \
          $(BINDIR)/BinaryTreeNode.class $(BINDIR)/BinaryTree.class \
          $(BINDIR)/BinarySearchTree.class $(BINDIR)/TokTik.class

default: $(CLASSES)

clean:
	rm $(BINDIR)/*.class

run:
	java -cp $(BINDIR) TokTik

javadoc:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java
