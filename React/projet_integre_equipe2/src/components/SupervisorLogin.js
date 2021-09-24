import _ from 'lodash';
import React from 'react'
import { useState } from 'react'

const SupervisorLogin = ({ login }) => {
    const [supervisor, setSupervisor] = useState({ lastName: "", firstName: "", matricule: "", password: "" })
    const [error, setError] = useState({credentials:"" })

    const onSubmit = (e) => {
        e.preventDefault()
        if (!_.isEmpty(error.credentials) ||_.isEmpty(supervisor.password) || _.isEmpty(supervisor.matricule)) {
            setError({...error, credentials: "Matricule ou mot de passe incorrect"})
            return
        } else {
            console.log(supervisor)
        }
        login({ supervisor })
    }

    return (
        <div>
            <form className="container-fluid" onSubmit={onSubmit}>
                <div className="form-group">
                    {error.credentials !== "" ? error.credentials : ""}
                    <label htmlFor="matriculeSupervisor" className="text-secondary"><i className="fas fa-id-badge"></i> Matricule: </label>
                    <input type="text" className="form-control text-center" id="matriculeSupervisor" name="matricule" placeholder="Entrez votre matricule" onChange={(e) => setSupervisor({...supervisor, matricule: e.target.value}) } required />
                </div>
                <div className="form-group">
                    <label htmlFor="passwordSupervisor" className="text-secondary"><i className="fas fa-lock"></i> Mot de passe: </label>
                    <input type="password" className="form-control text-center" id="passwordSupervisor" name="password" placeholder="Entrez votre mot de passe" onChange={(e) => setSupervisor({...supervisor, password: e.target.value}) } required />
                </div>
                <div className="d-flex justify-content-end">
                    <button type="submit" className="btn grad text-white ">Connexion</button>
                </div>
            </form>
        </div>
    )
}

export default SupervisorLogin
