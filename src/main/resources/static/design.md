# TÀI LIỆU THIẾT KẾ RESTFUL API
**Hệ thống:** Quản lý Công việc (Task) và Người dùng (User)

## 1. Mục tiêu và Tiêu chuẩn Thiết kế
- Áp dụng nguyên tắc thiết kế RESTful API, sử dụng danh từ số nhiều cho các định danh tài nguyên (Resource Identifiers).
- Sử dụng các phương thức HTTP (HTTP Methods) chuẩn xác (GET, POST, PATCH, DELETE) tương ứng với các thao tác CRUD.
- Xử lý các nghiệp vụ lọc (Filtering) thông qua tham số truy vấn (Query Parameters).
- Thể hiện rõ mối quan hệ thực thể (Entity Relationship) giữa `User` và `Task` thông qua cấu trúc URI.

---

## 2. API Quản lý Người dùng (User Management)

| Nghiệp vụ | Phương thức | Endpoint | Mô tả chi tiết |
| :--- | :--- | :--- | :--- |
| Truy xuất toàn bộ người dùng | `GET` | `/users` | Lấy danh sách tất cả bản ghi người dùng hiện có trong hệ thống. |
| Tạo mới người dùng | `POST` | `/users` | Khởi tạo một bản ghi người dùng mới. Payload (định dạng JSON) được truyền qua Request Body. |
| Cập nhật vai trò (Role) | `PATCH` | `/users/{id}/role` | Cập nhật cục bộ thuộc tính `role` của người dùng được chỉ định bởi Path Variable `{id}`. |
| Xóa người dùng | `DELETE` | `/users/{id}` | Xóa hoàn toàn bản ghi người dùng tương ứng với `{id}` khỏi hệ thống. |

---

## 3. API Quản lý Công việc (Task Management)

| Nghiệp vụ | Phương thức | Endpoint | Mô tả chi tiết |
| :--- | :--- | :--- | :--- |
| Truy xuất toàn bộ công việc | `GET` | `/tasks` | Lấy danh sách tất cả bản ghi công việc. |
| Tạo mới công việc | `POST` | `/tasks` | Khởi tạo một công việc mới. Payload (định dạng JSON) được truyền qua Request Body. |
| Cập nhật trạng thái (Status) | `PATCH` | `/tasks/{id}/status` | Cập nhật cục bộ thuộc tính `status` của công việc được chỉ định bởi Path Variable `{id}`. |
| Xóa công việc | `DELETE` | `/tasks/{id}` | Xóa bản ghi công việc tương ứng với `{id}` khỏi hệ thống. |

---

## 4. API Truy vấn và Liên kết Thực thể (Relationships & Filtering)

| Nghiệp vụ | Phương thức | Endpoint | Mô tả chi tiết |
| :--- | :--- | :--- | :--- |
| Lọc công việc ưu tiên cao | `GET` | `/tasks?priority=high` | Lọc và trả về tập hợp các công việc có thuộc tính mức độ ưu tiên (`priority`) bằng `high`. |
| Truy xuất công việc theo User | `GET` | `/users/{id}/tasks` | Lấy danh sách toàn bộ công việc đã được phân công cho người dùng cụ thể (`{id}`). |
| Lọc công việc ưu tiên cao của User cụ thể (ID = 1) | `GET` | `/users/1/tasks?priority=high` | Kết hợp URI đa cấp và Query Parameter để truy xuất các công việc có `priority=high` của người dùng mang ID là 1. |
| Phân công công việc | `PATCH` | `/tasks/{id}/assign` | Cập nhật khóa ngoại (`userId`) cho bản ghi công việc `{id}`. Request Body chứa ID của người dùng được phân công (VD: `{ "userId": 1 }`). |