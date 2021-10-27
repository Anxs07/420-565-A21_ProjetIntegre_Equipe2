import React from 'react'
import { useHistory } from 'react-router-dom'
import { useEffect, useState } from 'react'
import StudentNavbar from '../StudentNavbar'

const StudentSignContract = () => {
    const history = useHistory()
    const historyState = history.location.state

    return (
        <div className="grad ">
            <StudentNavbar useStudent={historyState} />
            <div className="d-flex justify-content-center my-5 py-2">
                <div className="jumbotron jumbotron-fluid bg-light rounded w-50 shadow reactivescreen">
                    <form className="container-fluid">
                        <h1 className="text-center">Contrat</h1>
                        <div className="form-group">
                            <label htmlFor="adminName" className="text-secondary">Le gestionnaire de stage : </label>
                            <input type="text" className="form-control text-center" id="adminName" name="adminName" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="monitorName" className="text-secondary"> L'employeur : </label>
                            <input type="text" className="form-control text-center" id="monitorName" name="monitorName" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="studentName" className="text-secondary"> L'étudiant : </label>
                            <input type="text" className="form-control text-center" id="studentName" name="studentName" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="location" className="text-secondary">Endroit du stage : </label>
                            <input type="text" className="form-control text-center" id="location" name="location" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="duration" className="text-secondary">Durée du stage : </label>
                            <input type="text" className="form-control text-center" id="duration" name="duration" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="schedule" className="text-secondary">Horaire de travail : </label>
                            <input type="password" className="form-control text-center" id="schedule" name="schedule" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="salary" className="text-secondary">Salaire : </label>
                            <input type="password" className="form-control text-center" id="salary" name="salary" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="duties" className="text-secondary">Taches et responsabilités du stagiaire : </label>
                            <textarea type="text" className="form-control text-center" id="duties" name="duties" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="responsability" className="text-secondary">Responsabilités : </label>
                            <textarea type="text" className="form-control text-center" id="responsability" name="responsability" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="signatureStudent" className="text-secondary">Signature de l'étudiant : </label>
                            <input type="text" className="form-control text-center" id="signatureStudent" name="signatureStudent" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="signatureStudentDate" className="text-secondary">Date de signature de l'étudiant : </label>
                            <input type="text" className="form-control text-center" id="signatureStudentDate" name="signatureStudentDate" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="signatureMonitor" className="text-secondary">Signature employeur : </label>
                            <input type="text" className="form-control text-center" id="signatureMonitor" name="signatureMonitor" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="signatureMonitorDate" className="text-secondary">Date de signature de l'employeur : </label>
                            <input type="text" className="form-control text-center" id="signatureMonitorDate" name="signatureMonitorDate" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="signatureAdmin" className="text-secondary">Signature du gestionnaire : </label>
                            <input type="text" className="form-control text-center" id="signatureAdmin" name="signatureAdmin" readOnly />
                        </div>
                        <div className="form-group">
                            <label htmlFor="signatureAdminDate" className="text-secondary">Date de signature du gestionnaire : </label>
                            <input type="text" className="form-control text-center" id="signatureAdminDate" name="signatureAdminDate" readOnly />
                        </div>
                        <div className="d-flex justify-content-center mt-4">
                            <button type="submit" className="btn btn-block grad text-white">Soumettre</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default StudentSignContract