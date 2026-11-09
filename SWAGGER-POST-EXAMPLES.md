# AutoLoc — Exemples Swagger pour les relations

Base URL : http://localhost:8080

Avant de créer Maintenance, Paiement ou Réservation, créer d'abord les entités parentes avec leurs endpoints POST et récupérer les identifiants renvoyés par l'API.

## 1. Maintenance

Endpoint : POST /maintenance/addMaintenance

Il faut fournir l'identifiant d'un véhicule déjà existant.

```json
{
  "dateDebut": "2026-11-09",
  "dateFin": "2026-11-10",
  "description": "Révision du véhicule",
  "vehicule": {
    "idVehicule": 3
  }
}
```

## 2. Paiement

Endpoint : POST /paiement/addPaiement

Il faut fournir l'identifiant d'un contrat déjà existant. La forme complète de l'objet Contrat ci-dessous est acceptée par l'API.

```json
{
  "montant": 120.00,
  "datePaiement": "2026-11-09",
  "modePaiement": "CARTE",
  "contrat": {
    "idContrat": 5,
    "dateSignature": "2026-11-09",
    "montantTotal": 120.00,
    "valide": false
  }
}
```

Après la modification de l'entité Contrat, la référence par ID seul est également conçue pour être désérialisée :

```json
{
  "montant": 120.00,
  "datePaiement": "2026-11-09",
  "modePaiement": "CARTE",
  "contrat": {
    "idContrat": 5
  }
}
```

## 3. Réservation

Endpoint : POST /reservation/addReservation

Il faut fournir les identifiants d'un client et d'un véhicule déjà existants.

```json
{
  "dateDebut": "2026-11-12",
  "dateFin": "2026-11-13",
  "statut": "EN_ATTENTE",
  "client": {
    "idClient": 2
  },
  "vehicule": {
    "idVehicule": 3
  }
}
```

## Corrections JPA appliquées

- Maintenance.vehicule → `@JoinColumn(name = "vehicule_id", nullable = false)`
- Paiement.contrat → `@JoinColumn(name = "contrat_id", nullable = false)`
- Reservation.client → `@JoinColumn(name = "client_id", nullable = false)`
- Reservation.vehicule → `@JoinColumn(name = "vehicule_id", nullable = false)`

Ces mappings utilisent les colonnes FK qui existent déjà dans MySQL au lieu de colonnes relationnelles générées avec d'autres noms.

Remarque : remplacer les IDs 2, 3 et 5 par les IDs réellement renvoyés par tes propres créations POST. Ne pas réutiliser les IDs d'exemple sans vérifier qu'ils existent.
