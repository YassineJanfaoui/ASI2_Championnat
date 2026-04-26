package tn.esprit.ds.championnat.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ChampionnatAspect {

    @Before("execution(* tn.esprit.ds.championnat.services.IChampionnatServices.historiqueContratsEquipe(..))")
    public void beforeHistoriqueContrats(JoinPoint jp) {
        System.out.println("[BEFORE] historiqueContratsEquipe - args: " + jp.getArgs()[0]);
    }

    @After("execution(* tn.esprit.ds.championnat.services.IChampionnatServices.historiqueContratsEquipe(..))")
    public void afterHistoriqueContrats(JoinPoint jp) {
        System.out.println("[AFTER] historiqueContratsEquipe finished");
    }

    @Around("execution(* tn.esprit.ds.championnat.services.IChampionnatServices.nbPointsParPilotesUneEquipeChampionnatPourUneAnne(..))")
    public Object aroundNbPoints(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[AROUND] nbPointsParPilotes - before");
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        System.out.println("[AROUND] nbPointsParPilotes - after (" + (System.currentTimeMillis() - start) + "ms) result: " + result);
        return result;
    }

    @AfterReturning(pointcut = "execution(* tn.esprit.ds.championnat.services.IChampionnatServices.moyennePositionsEntreDeuxDate(..))", returning = "result")
    public void afterReturningMoyenne(JoinPoint jp, Object result) {
        System.out.println("[AFTER_RETURNING] moyennePositions result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* tn.esprit.ds.championnat.services.IChampionnatServices.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint jp, Exception ex) {
        System.out.println("[AFTER_THROWING] " + jp.getSignature().getName() + " threw: " + ex.getMessage());
    }
}
