package ra.business;

import ra.entity.Degree;

import java.util.List;

public interface IManager {
    List<Degree> getAllDegrees();
    Degree  getDegreeByEmpId(String empId);
    Degree  getDegreeByDegreeName(String degreeName);
    void  addDegree(Degree degree);
    void  updateDegree(int degreeId,Degree degree);
    void  deleteDegree(int degreeId);

}
