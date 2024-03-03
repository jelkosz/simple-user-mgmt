import React, { useState, useEffect } from 'react';

const App = () => {
	const [users, setUsers] = useState([]);

	const fetchUsers = () => {
		fetch('/users')
			.then((response) => response.json())
			.then((data) => {
				setUsers(data);
			})
			.catch((err) => {
				console.log(err.message);
			});
	};

	const deleteUser = (userId) => () => {
		fetch(`/users-protected/${userId}`, { method: "DELETE" })
			.then((response) => response.json())
			.then((data) => {
				console.log(`successfully deleted: ${data.username}`);
				fetchUsers();
			})
			.catch((err) => {
				console.log(err.message);
			});
	};

	useEffect(() => {
		fetchUsers();
	}, []);

	return (
		<div>
			<h1>List of users:</h1>
			<table>
				<tbody>
					{users.map((user) => {
						return (
							<tr key={user.id}>
								<td> <b>username:</b> {user.username} </td>
								<td> <b>Full Name:</b> {user.name} </td>								
								<td> <button onClick={deleteUser(user.id)}>delete</button> </td>
							</tr>
						)
					})}
				</tbody>
			</table>
		</div>
	);
}

export default App;
