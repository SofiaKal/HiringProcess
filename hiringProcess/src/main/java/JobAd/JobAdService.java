package JobAd;

import com.example.hiringProcess.Candidate.Candidate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobAdService {
    private final JobAdRepository jobAdRepository;

    @Autowired
    public JobAdService(JobAdRepository jobAdRepository) {
        this.jobAdRepository = jobAdRepository;
    }

    @GetMapping(path="/jobAds")//χρειαζεται??
    public List<JobAd> getJobAds(){
        return jobAdRepository.findAll();
    }

    @GetMapping(path="/jobAd")
    public Optional<JobAd> getJobAd(Integer jobAdId) {
        return jobAdRepository.findById(jobAdId);
    }

    public void addNewJobAd(JobAd jobAd) {
        Optional<JobAd> jobAdByName = jobAdRepository.findJobAdByTitle(jobAd.getTitle());
        if (jobAdByName.isPresent()) {
            throw new IllegalStateException("Title already taken");
        }
        jobAdRepository.save(jobAd);
    }

    public void deleteJobAd(Integer jobAdId) {
        boolean exists = jobAdRepository.existsById(jobAdId);

        if(!exists){
            throw  new IllegalStateException("jobAd with id" + jobAdId + "does not exists");
        }
        jobAdRepository.deleteById(jobAdId);
    }

//    @Transactional
//    public void updateJobAd(Integer jobAdId, String name) {
//        JobAd jobAd = jobAdRepository.findById(jobAdId).orElseThrow(() -> new IllegalStateException(
//                "jobAd with id" + jobAdId + "does not exists"));
//
//        if(name != null && !name.isEmpty() && !Objects.equals(jobAd.getName(),name)){
//            jobAd.setName(name);
//        }
 //   }

}
