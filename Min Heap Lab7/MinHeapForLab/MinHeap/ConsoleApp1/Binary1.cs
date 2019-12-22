//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Text;
//using System.Threading.Tasks;

//namespace MinHeapLab
//{
//    class BinaryHeap
//    {
       
//        static void Main(string[] args)
//        {
//            //Initialise a heap to some size
//            int sizeOfHeap = 10;
//            BinaryHeap<int> sampleHeap;
//            sampleHeap = new BinaryHeap<int>(sizeOfHeap);

//            //populate a heap
//            for (int i = 0; i < sizeOfHeap; i++)
//            {
//                sampleHeap.AddItem(i);
//            }
//            //This line shows how to use comparison, element 5 is less than element 6 and returns -1
//            Console.WriteLine(sampleHeap.GetItem(5).CompareTo(sampleHeap.GetItem(6)));
//            Console.WriteLine("element 5 is less than 6");

//            //Print each  element in the heap
//            Console.Write("Useless Linear Heap: ");
//            foreach (int i in sampleHeap)
//            {
//                Console.Write(i + " ");
//            }
//            Console.WriteLine();

//            BinaryHeap<int> sampleHeap2;
//            sampleHeap2 = new BinaryHeap<int>(12);
//            sampleHeap2.AddItem(1);
//            sampleHeap2.AddItem(3);
//            sampleHeap2.AddItem(36);
//            sampleHeap2.AddItem(2);
//            sampleHeap2.AddItem(19);
//            sampleHeap2.AddItem(25);
//            sampleHeap2.AddItem(100);
//            sampleHeap2.AddItem(17);
//            sampleHeap2.AddItem(7);
//            sampleHeap2.AddItem(30);
//            sampleHeap2.AddItem(20);
//            sampleHeap2.AddItem(10);

//            sampleHeap2.MinHeapify(0);

//            foreach (int i in sampleHeap2)
//            {
//                Console.WriteLine(i);
//            }
//            Console.ReadLine();

//        }
//    }

//    //internal class BinaryHeap<T> : BinaryHeap
//    //{
//    //    private int sizeOfHeap;

//    //    public BinaryHeap(int sizeOfHeap)
//    //    {
//    //        this.sizeOfHeap = sizeOfHeap;
//    //    }

//    //    internal void AddItem(int i)
//    //    {
//    //        throw new NotImplementedException();
//    //    }

//    //    internal object GetItem(int v)
//    //    {
//    //        throw new NotImplementedException();
//    //    }
//    //}
//}


