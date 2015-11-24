package optimierung;

import java.util.LinkedList;
import java.util.List;

import daten.*;

public class optimierung {

	class Worker implements Runnable{
		Fach fach;
		Praktikum prScr;
		Praktikum prDes;
		Student studtScr;
		Student studtDes;
		double max=0;
		Worker(Fach fach,Praktikum pr){
			this.fach=fach;
			this.prScr=pr;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			double happyScr=prScr.getHappy();
			double happyDes=0;
			for(Student studt:prScr.getStudenten()){	
				for(Praktikum pr :fach.getPraktikas()){
					if(pr!=prScr&&studt.isfree(pr.getId())){
						happyDes= pr.getHappy();
						for(Student studtTemp:pr.getStudenten()){
							if(studtTemp.isfree(prScr.getId())){
								pr.removeStudt(studtTemp);
								pr.addStudt(studt);
								prScr.addStudt(studtTemp);
								prScr.removeStudt(studt);
								double temp = prScr.getHappy()-happyScr+pr.getHappy()-happyDes;
								if(temp>max){
									prDes=pr;
									studtDes=studtTemp;
									studtScr=studt;
									max=temp;
								}
								pr.removeStudt(studt);
								pr.addStudt(studtTemp);
								prScr.addStudt(studt);
								prScr.removeStudt(studtTemp);
							}
						}
					}
				}
			}
		}
		
	}
	public void optimum (Praktikas data){
		double oldhappy=data.getHappyAll();
		double newhappy=0;
		do{
			List<Worker> list=new LinkedList<Worker>();
			for(Praktikum pr :data.getA().getPraktikas()){
				list.add(new Worker(data.getA(),pr));
			}
			for(Praktikum pr :data.getB().getPraktikas()){
				list.add(new Worker(data.getB(),pr));
			}
			for(Praktikum pr :data.getC().getPraktikas()){
				list.add(new Worker(data.getC(),pr));
			}
			for(Worker work:list){
				work.run();
			}
			for(Worker work:list){
				work.
			}
		}while(oldhappy<newhappy);
	}
}
