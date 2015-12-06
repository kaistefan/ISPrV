package optimierung;

import java.util.LinkedList;
import java.util.List;

import daten.*;

public class Optimierung {

	class Worker extends Thread{
		Fach fach;
		Praktikum prScrF;
		Praktikum prDes;
		Student studtScr;
		Student studtDes;
		double max=0;
		Worker(Fach fach){
			this.fach=fach;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			double happyDes=0;
			for(int i =0;i<fach.getPraktikas().length;i++){
				Praktikum prScr =fach.getPraktikas()[i];
				double happyScr=prScr.getHappy();
				for(int l =0;l<prScr.getStudenten().size();l++){
					Student studt=prScr.getStudenten().get(l);
					for(Praktikum pr :fach.getPraktikas()){
						if(pr!=prScr&&studt.isfree(pr.getId())){
							happyDes= pr.getHappy();
							for(int j =0;j<pr.getStudenten().size();j++){
								Student studtTemp=pr.getStudenten().get(j);
								if(studtTemp.isfree(prScr.getId())){
									double temp = (prScr.testSwitch(studt, studtTemp)-happyScr)+(pr.testSwitch(studtTemp,studt)-happyDes);
									if(temp>max){
										prScrF=prScr;
										prDes=pr;
										studtDes=studtTemp;
										studtScr=studt;
										max=temp;
									}	
								}	
							}
						}
					}
				}
			}
		}
		
	}
	public void optimum (Praktikas data){
		double oldhappy=0;
		double newhappy=data.getHappyAll();
		do{
			oldhappy=newhappy;
			List<Worker> list=new LinkedList<Worker>();
				list.add(new Worker(data.getA()));
			
			
				list.add(new Worker(data.getB()));
			
			
				list.add(new Worker(data.getC()));
			
			for(Worker work:list){
				work.run();
			}
			double max=0;
			Worker maxWorker = null;
			for(Worker work:list){
				try {
					work.join();
					if(work.max>max){
						maxWorker=work;
						max=maxWorker.max;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(max>0){
				maxWorker.prDes.removeStudt(maxWorker.studtDes);
				maxWorker.prScrF.removeStudt(maxWorker.studtScr);
				maxWorker.prDes.addStudt(maxWorker.studtScr);		
				maxWorker.prScrF.addStudt(maxWorker.studtDes);			
				newhappy=data.getHappyAll();
			}
		}while(oldhappy<newhappy);
	}
}
