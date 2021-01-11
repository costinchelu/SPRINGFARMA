package ro.springmongo.repository;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.springmongo.entity.Produs;
import ro.springmongo.entity.RaportCantitateSauPret;
import ro.springmongo.entity.RaportProducatori;

import java.util.List;


@Repository
public interface ProdusRepository extends MongoRepository<Produs, String> {


    List<Produs> findByDenComerciala(String denComerciala);

    List<Produs> findByProducatorAndDci_DenDci(String producator, String denDci);

    List<Produs> findByDenComercialaOrDci_DenDci(String denComerciala, String denDci);

    List<Produs> findByPretGreaterThanEqual(double pret);

    List<Produs> findByIndicatiiContaining(String... indicatie);

    List<Produs> findByProducatorLike(String producator);

    List<Produs> findByDenComercialaStartsWith(String denComerciala);


    @Aggregation(pipeline={"{ $match: {\"pret\": {$gte: ?0}}}",
            "{ $addFields: {valoare: { $multiply: [\"$pret\", \"$cantitate\"]}}}",
            "{ $group: {_id: \"$producator\", valoare: {$sum: \"$valoare\"}}}",
            "{ $sort: {valoare: 1}}",
            "{ $match: {\"_id\": {$ne: null}}}"})
    AggregationResults<RaportProducatori> raportProducatori(double pret);


    @Aggregation(pipeline={"{ $match: { $or: [{ cantitate: { $gte: ?0}}, { pret: { $gte: ?1}}]}}",
            "{ $project: {denComerciala: 1, producator: 1, pret: 1, cantitate: 1, valoare: { $multiply: [\"$pret\", \"$cantitate\"]}, _id: 0}}",
            "{ $sort: {valoare: 1}}"})
    AggregationResults<RaportCantitateSauPret> raportCantitateSauPret(int cantitate, double pret);
}
