package com.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hibernate.inheritance.Brainiac;
import com.hibernate.inheritance.Fighter;
import com.hibernate.inheritance.Genius;
import com.hibernate.inheritance.HighSchool;
import com.hibernate.inheritance.PrimarySchool;
import com.hibernate.inheritance.RedTagged;
import com.hibernate.inheritance.Student;
import com.hibernate.inheritance.Wicked;
import com.hibernate.inheritance.YellowTagged;
import com.hibernate.util.HibernateUtil;

/**
 * Client code to retrieve data from domain classes having Inheritance. 
 * This select client works with all three types of Inheritance mapping.
 * 1> Table Per Subclass Inheritance Mapping 		- Add student1.hbm.xml in cfg file
 * 2> Table Per Class Inheritance Mapping 			- Add student2.hbm.xml in cfg file
 * 3> Table Per Concrete Class Inheritance Mapping 	- Add student3.hbm.xml in cfg file
 * @author bkar
 *
 */
public class H01InheritanceSelect {
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session se = null;
		try {
			sf = HibernateUtil.getSessionFactory();
			se = sf.openSession();
			System.out.println("~~~~~~~~~~~~~~~~~~~Student~~~~~~~~~~~~~~~~~~~");
			Query query = se.createQuery("FROM Student");
			List stul = query.list();
			for(Object obj:stul) {
				Student student = (Student)obj;
				System.out.println("Student :: SNAME : "+student.getSname()+", \t\t SROLL : "+student.getSroll()+", \t\t GENDER : "+student.getGender());
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~HighSchool~~~~~~~~~~~~~~~~~~~");
			query = se.createQuery("FROM HighSchool");
			stul = query.list();
			for(Object obj:stul) {
				HighSchool highSchool = (HighSchool)obj;
				System.out.println("*******");
				System.out.println("Properties in HighSchool object from Student class :: "
				+"  \t\t SNAME : "		+highSchool.getSname()
				+", \t\t SROLL : "		+highSchool.getSroll()
				+", \t\t GENDER : "		+highSchool.getGender());
				
				System.out.println("Properties in HighSchool object from HighSchool class :: "
				+"  \t\t Hroll : "		+highSchool.getHroll()
				+", \t\t Hname : "		+highSchool.getHname()
				+", \t\t Game : "		+highSchool.getGame()
				+", \t\t InLove : "		+highSchool.isInlove()
				+", \t\t ArrestCount : "+highSchool.getArrestcount());
				System.out.println("*******");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~PrimarySchool~~~~~~~~~~~~~~~~~~~");
			query = se.createQuery("FROM PrimarySchool");
			stul = query.list();
			for(Object obj:stul) {
				PrimarySchool primarySchool = (PrimarySchool)obj;
				System.out.println("*******");
				System.out.println("Properties in PrimarySchool object from Student class :: "
				+"  \t\t SNAME : "		+primarySchool.getSname()
				+", \t\t SROLL : "		+primarySchool.getSroll()
				+", \t\t GENDER : "		+primarySchool.getGender());
				
				System.out.println("Properties in PrimarySchool object from PrimarySchool class :: "
				+"  \t\t Proll : "		+primarySchool.getProll()
				+", \t\t BeltColor : "	+primarySchool.getBeltcolor()
				+", \t\t TieColor : "	+primarySchool.getTiecolor());
				System.out.println("*******");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~YellowTagged~~~~~~~~~~~~~~~~~~~");
			query = se.createQuery("FROM YellowTagged");
			stul = query.list();
			for(Object obj:stul) {
				YellowTagged yellowTagged = (YellowTagged)obj;
				System.out.println("*******");
				System.out.println("Properties in YellowTagged object from Student class :: "
				+"  \t\t SNAME : "		+yellowTagged.getSname()
				+", \t\t SROLL : "		+yellowTagged.getSroll()
				+", \t\t GENDER : "		+yellowTagged.getGender());
				
				System.out.println("Properties in YellowTagged object from PrimarySchool class :: "
				+"  \t\t Proll : "		+yellowTagged.getProll()
				+", \t\t BeltColor : "	+yellowTagged.getBeltcolor()
				+", \t\t TieColor : "	+yellowTagged.getTiecolor());
				
				System.out.println("Properties in YellowTagged object from YellowTagged class :: "
				+"  \t\t Yroll : "		+yellowTagged.getYroll()
				+", \t\t Yname : "		+yellowTagged.getYname()
				+", \t\t Bookworm : "	+yellowTagged.isBookworm()
				+", \t\t IQ : "			+yellowTagged.getIq());
				System.out.println("*******");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~Genius~~~~~~~~~~~~~~~~~~~");
			query = se.createQuery("FROM Genius");
			stul = query.list();
			for(Object obj:stul) {
				Genius genius = (Genius)obj;
				System.out.println("*******");
				System.out.println("Properties in Genius object from Student class :: "
				+"  \t\t SNAME : "		+genius.getSname()
				+", \t\t SROLL : "		+genius.getSroll()
				+", \t\t GENDER : "		+genius.getGender());
				
				System.out.println("Properties in Genius object from PrimarySchool class :: "
				+"  \t\t Proll : "		+genius.getProll()
				+", \t\t BeltColor : "	+genius.getBeltcolor()
				+", \t\t TieColor : "	+genius.getTiecolor());
				
				System.out.println("Properties in YellowTagged object from Brainiac class :: "
				+"  \t\t Yroll : "		+genius.getYroll()
				+", \t\t Yname : "		+genius.getYname()
				+", \t\t Bookworm : "	+genius.isBookworm()
				+", \t\t IQ : "			+genius.getIq());
				
				System.out.println("Properties in Genius object from Genius class :: "
				+"  \t\t GetDumpedCount : "	+genius.getGetDumpedCount()
				+", \t\t CrushCount : "		+genius.getCrushCount()
				+", \t\t CrashCount : "		+genius.getCrashCount());
				System.out.println("*******");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~Brainiac~~~~~~~~~~~~~~~~~~~");
			query = se.createQuery("FROM Brainiac");
			stul = query.list();
			for(Object obj:stul) {
				Brainiac brainiac = (Brainiac)obj;
				System.out.println("*******");
				System.out.println("Properties in Brainiac object from Student class :: "
				+"  \t\t SNAME : "		+brainiac.getSname()
				+", \t\t SROLL : "		+brainiac.getSroll()
				+", \t\t GENDER : "		+brainiac.getGender());
				
				System.out.println("Properties in Brainiac object from PrimarySchool class :: "
				+"  \t\t Proll : "		+brainiac.getProll()
				+", \t\t BeltColor : "	+brainiac.getBeltcolor()
				+", \t\t TieColor : "	+brainiac.getTiecolor());
				
				System.out.println("Properties in YellowTagged object from Brainiac class :: "
				+"  \t\t Yroll : "		+brainiac.getYroll()
				+", \t\t Yname : "		+brainiac.getYname()
				+", \t\t Bookworm : "	+brainiac.isBookworm()
				+", \t\t IQ : "			+brainiac.getIq());
				
				System.out.println("Properties in Brainiac object from Brainiac class :: "
				+"  \t\t ReadBookCount : "		+brainiac.getReadBookCount()
				+", \t\t YellowTeethCount : "	+brainiac.getYellowTeethCount()
				+", \t\t GetBeatenByFightersCount : "		+brainiac.getGetBeatenByFightersCount());
				System.out.println("*******");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~RedTagged~~~~~~~~~~~~~~~~~~~");
			query = se.createQuery("FROM RedTagged");
			stul = query.list();
			for(Object obj:stul) {
				RedTagged redtagged = (RedTagged)obj;
				System.out.println("*******");
				System.out.println("Properties in RedTagged object from Student class :: "
				+"  \t\t SNAME : "		+redtagged.getSname()
				+", \t\t SROLL : "		+redtagged.getSroll()
				+", \t\t GENDER : "		+redtagged.getGender());
				
				System.out.println("Properties in RedTagged object from PrimarySchool class :: "
				+"  \t\t Proll : "		+redtagged.getProll()
				+", \t\t BeltColor : "	+redtagged.getBeltcolor()
				+", \t\t TieColor : "	+redtagged.getTiecolor());
				
				System.out.println("Properties in RedTagged object from RedTagged class :: "
				+"  \t\t Rcount : "		+redtagged.getRcount()
				+", \t\t Fname : "		+redtagged.getFname()
				+", \t\t FightFought : "+redtagged.getFightfought()
				+", \t\t ToothBroken : "+redtagged.getToothbroken());
				System.out.println("*******");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~Fighter~~~~~~~~~~~~~~~~~~~");
			query = se.createQuery("FROM Fighter");
			stul = query.list();
			for(Object obj:stul) {
				Fighter fighter = (Fighter)obj;
				System.out.println("*******");
				System.out.println("Properties in Fighter object from Student class :: "
				+"  \t\t SNAME : "		+fighter.getSname()
				+", \t\t SROLL : "		+fighter.getSroll()
				+", \t\t GENDER : "		+fighter.getGender());
				
				System.out.println("Properties in Fighter object from PrimarySchool class :: "
				+"  \t\t Proll : "		+fighter.getProll()
				+", \t\t BeltColor : "	+fighter.getBeltcolor()
				+", \t\t TieColor : "	+fighter.getTiecolor());
				
				System.out.println("Properties in Fighter object from RedTagged class :: "
				+"  \t\t Rcount : "		+fighter.getRcount()
				+", \t\t Fname : "		+fighter.getFname()
				+", \t\t FightFought : "+fighter.getFightfought()
				+", \t\t ToothBroken : "+fighter.getToothbroken());
				
				System.out.println("Properties in Fighter object from Fighter class :: "
				+"  \t\t PunchCount : "			+fighter.getPunchCount()
				+", \t\t KickCount : "			+fighter.getKickCount()
				+", \t\t BeatedGeniusCount : "	+fighter.getBeatenGeniusCount()
				+", \t\t BeatedBrainiacCount : "+fighter.getBeatenBrianiacCount());
				System.out.println("*******");
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~Wicked~~~~~~~~~~~~~~~~~~~");
			query = se.createQuery("FROM Wicked");
			stul = query.list();
			for(Object obj:stul) {
				Wicked wicked = (Wicked)obj;
				System.out.println("*******");
				System.out.println("Properties in Wicked object from Student class :: "
				+"  \t\t SNAME : "		+wicked.getSname()
				+", \t\t SROLL : "		+wicked.getSroll()
				+", \t\t GENDER : "		+wicked.getGender());
				
				System.out.println("Properties in Wicked object from PrimarySchool class :: "
				+"  \t\t Proll : "		+wicked.getProll()
				+", \t\t BeltColor : "	+wicked.getBeltcolor()
				+", \t\t TieColor : "	+wicked.getTiecolor());
				
				System.out.println("Properties in Wicked object from RedTagged class :: "
				+"  \t\t Rcount : "		+wicked.getRcount()
				+", \t\t Fname : "		+wicked.getFname()
				+", \t\t FightFought : "+wicked.getFightfought()
				+", \t\t ToothBroken : "+wicked.getToothbroken());
				
				System.out.println("Properties in Wicked object from Wicked class :: "
				+"  \t\t Speciality : "		+wicked.getSpeciality()
				+", \t\t FightOrganized : "	+wicked.getFightOrganised()
				+", \t\t GetCaught : "		+wicked.getGetCaught()
				+", \t\t SuccessRate : "	+wicked.getSuccessRate());
				System.out.println("*******");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			se.close();
			sf.close();
		}
	}
}
